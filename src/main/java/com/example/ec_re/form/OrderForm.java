package com.example.ec_re.form;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {
	@NotBlank
	@Size(min = 1, max = 128)
	private String destinationName;

	@Email
	@Size(min = 1, max = 128)
	private String destinationEmail;

	@Pattern(regexp = "^\\d{3}-\\d{4}$")
	private String destinationZipcode;

	@NotBlank
	@Size(min = 1, max = 128)
	private String destinationAddress;

	@Pattern(regexp = "^\\d{3,4}-\\d{4}-\\d{4}$")
	private String destinationTel;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String deliveryDate;

	@Pattern(regexp = "^[0-8]$")
	private String deliveryTime;

	@Pattern(regexp = "0|1")
	private String paymentMethod;

	public LocalDateTime generateOrderDeliveryDateTime() {
		LocalDate deliveryDate =
				LocalDate.parse(this.deliveryDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalTime deliveryTime = null;
		switch (this.deliveryTime) {
			case "0": {
				deliveryTime = LocalTime.of(10, 0);
			}
				break;
			case "1": {
				deliveryTime = LocalTime.of(11, 0);
			}
				break;
			case "2": {
				deliveryTime = LocalTime.of(12, 0);
			}
				break;
			case "3": {
				deliveryTime = LocalTime.of(13, 0);
			}
				break;
			case "4": {
				deliveryTime = LocalTime.of(14, 0);
			}
				break;
			case "5": {
				deliveryTime = LocalTime.of(15, 0);
			}
				break;
			case "6": {
				deliveryTime = LocalTime.of(16, 0);
			}
				break;
			case "7": {
				deliveryTime = LocalTime.of(17, 0);
			}
				break;
			case "8": {
				deliveryTime = LocalTime.of(18, 0);
			}
				break;
			case "9": {
				deliveryTime = LocalTime.of(19, 0);
			}
				break;

			default:
				break;
		}
		LocalDateTime result = deliveryDate.atTime(deliveryTime);
		return result;
	}
}

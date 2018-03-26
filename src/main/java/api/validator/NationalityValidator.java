package api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.ArrayUtils;

public class NationalityValidator implements ConstraintValidator<Nationality, String> {

	private String[] invalidCountries = { "Germany", "India", "Pakistan" };

	@Override
	public boolean isValid(String value, ConstraintValidatorContext ctx) {
		if (ArrayUtils.contains(this.invalidCountries, value)) {
			return false;
		}
		return true;
	}
}
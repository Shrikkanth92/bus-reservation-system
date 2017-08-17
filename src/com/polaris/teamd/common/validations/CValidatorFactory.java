package com.polaris.teamd.common.validations;

public class CValidatorFactory implements CValidatorTypes {
	CValidator validator;

	public CValidator createValidator(int validator) {
		switch (validator) {
		case CDATEMAXVALUEVALIADTOR:
			return new CDateMaxValueValidator();
			
		case CDATEMINVALUEVALIDATOR:
			return new CDateMinValueValidator();
			
		case CDATEVALUERANGEVALIDATOR:
			return new CDateValueRangeValidator();
			
		case CDOUBLEMAXIMUMVALUEVALIDATOR:
			return new CDoubleMaximumValueValidator();
			
		case CDOUBLEMINIMUMVALUEVALIDATOR:
			return new CDoubleMinimumValueValidator();
			
		case CDOUBLEVALUERANGEVALIDATOR:
			return new CDoubleValueRangeValidator();
			
		case CFLOATMAXIMUMVALUEVALIDATOR:
			return new CFloatMaximumValueValidator();
			
		case CFLOATMINIMUMVALUEVALIDATOR:
			return new CFloatMinimumValueValidator();
			
		case CFLOATVALUERANGEVALIDATOR:
			return new CFloatValueRangeValidator();
			
		case CINTMAXIMUMVALUEVALIDATOR:
			return new CIntMaximumValueValidator();
		
		case CINTMINIMIUMVALUEVALIDATOR:
			return new CIntMinimunValueValidator();
			
		case CINTVALUERANGEVALIDATOR:
			return new CIntValueRangeValidator();
			
		case CSTRINGALPHAONLYVALIDATOR:
			return new CStringAlphaOnlyValidator();
			
		case CSTRINGDIGITSONLYVALIDATOR:
			return new CStringDigitsOnlyValidator();
			
		case CSTRINGLENGTHRANGEVALIDATOR:
			return new CStringLengthRangeValidator();
			
		case CSTRINGMAXLENGTHVALIDATOR:
			return new CStringMaxLengthValidator();
			
		case CSTRINGMINLENGTHVALIDATOR:
			return new CStringMinLengthValidator();
			

		default:
			return null;
		}
	}

}

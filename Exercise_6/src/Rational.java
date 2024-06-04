
public class Rational {
	private int _numerator;
	private int _denominator;
	private final int DEFAULT_NUMERATOR_VALUE = 1;
	private final int DEFAULT_DENOMINATOR_VALUE = 1;
	
	public Rational()
	{
		_numerator= DEFAULT_NUMERATOR_VALUE;
		_denominator= DEFAULT_DENOMINATOR_VALUE;
	}
	
	public Rational(int numerator, int denominator)
	{
		if(denominator == 0)
			throw new IllegalArgumentException("denominator can not be 0");
		_numerator = numerator;
		_denominator = denominator;
	}
	
	// copy ctr
	public Rational(Rational r)
	{
		_numerator = r._numerator;
		_denominator = r._denominator;
	}
	
	public boolean greaterThan(Rational rational)
	{
		return (_numerator * rational._denominator > _denominator * rational._numerator);
	}
	
	public boolean equals(Object other)
	{
		if(!(other instanceof Rational))
			return false;
		
		Rational rational = (Rational) other;
		return (_numerator * rational._denominator == _denominator * rational._numerator);
	}
	
	
	public int getNumerator()
	{
		return _numerator;
	}
	
	public int getDenominator()
	{
		return _denominator;
	}
	
	public String toString()
	{
		return String.format("(%s,%s) ", _numerator,_denominator);
	}
	
	public void plus(Rational rational)
	{
		_numerator = (_numerator * rational._denominator + _denominator * rational._numerator); 
		_denominator = _denominator * rational._denominator; 
		adjust();
	}
	
	public void minus(Rational rational)
	{
		Rational opposite = new Rational(rational._numerator, 0- rational._denominator);
		this.plus(opposite);
		adjust();
	}
	
	public void multiply(Rational rational)
	{
		_numerator = (_numerator * rational._numerator); 
		_denominator = _denominator * rational._denominator; 
		adjust();
	}
	
	public void devide(Rational rational)
	{
		if(rational._numerator == 0)
			throw new ArithmeticException("can not devide by zero");
		
		// in math a/b / c/d == a/b * d/c => so we use the multiply function we already have with creating new rational number - d/c 
		Rational inverse = new Rational(rational._denominator, rational._numerator);
		
		this.multiply(inverse);
	}
	
	public static int gcd(int x, int y) 
	{
		if(0==y)
			return x;
		else
			return gcd(y, x%y);
	}
	
	public void reduce()
	{
		int gcdValue = gcd(_numerator, _denominator);
		_numerator /= gcdValue;
		_denominator /= gcdValue;
	}
	
	public void adjust()
	{
		reduce();
		
		if( _denominator< 0)
		{
			_numerator *= (-1);
			_denominator *= (-1);
		}
	}
	
	
	
	
}

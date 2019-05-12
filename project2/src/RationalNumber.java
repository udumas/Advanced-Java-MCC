

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joelsalisbury
 */
public class RationalNumber implements RationalExpression
{

private int numerator;
private int denominator;

	public RationalNumber()
	{
		this.numerator=0;
		this.denominator=0;
	}
	public RationalNumber(int numerator, int denominator)
	{
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public RationalNumber(String expression)
	{
		this.numerator=Integer.parseInt((expression.split("/")[0]));
		if((expression.split("/").length>1))
		{
			this.denominator=Integer.parseInt((expression.split("/")[1]));
		}else{
			this.denominator=1;
		}
	}

	public RationalExpression sub(RationalExpression other)
	{
		RationalExpression output;
		if(other instanceof RationalNumber)
		{
			if (other.getDenominator()==this.denominator){
				output =  new RationalNumber((this.numerator-other.getNumerator()),this.denominator);
			}else{
			output = new RationalNumber(
				((this.numerator)*(other.getDenominator())) - ((other.getNumerator())*(this.denominator)),
				(this.denominator*other.getDenominator()));
                        }
			
		}else{
			output = new RationalNumber();
		}
		return output;
	}

	public RationalExpression add(RationalExpression other)
	{
		RationalExpression output;
		if(other instanceof RationalNumber)
		{
			if (other.getDenominator()==this.denominator){
				output =  new RationalNumber((this.numerator+other.getNumerator()),this.denominator);
			}else{
			output = new RationalNumber(
				((this.numerator)*(other.getDenominator())) + ((other.getNumerator())*(this.denominator)),
				(this.denominator*other.getDenominator()));
                        }
			
		}else{
			output = new RationalNumber();
		}
		return output;
	}

	public RationalExpression mlt(RationalExpression other)
	{
		RationalExpression output;
		if(other instanceof RationalNumber)
		{
			output =  new RationalNumber((this.numerator*other.getNumerator()),((this.denominator)*(other.getDenominator())));	
		}else{
			output = new RationalNumber();
		}
		return output;
	}

	public RationalExpression div(RationalExpression other)
	{
		RationalExpression output;
		if(other instanceof RationalNumber)
		{
			output =  new RationalNumber((this.numerator*other.getDenominator()),(this.denominator*other.getNumerator()));		
		}else{
			output = new RationalNumber();
		}
		return output;
		
	}
	public int getNumerator()
	{
		return this.numerator;
	}

	public int getDenominator()
	{
		return this.denominator;
	}

	public boolean gt(RationalExpression r)
	{
            boolean isGreaterThan =false;
            if((r instanceof RationalNumber)&&((((double)this.numerator)/((double)this.denominator))>(((double)r.getNumerator())/(((double)r.getDenominator())))))
            {
               isGreaterThan=true;
            }
            return isGreaterThan;
               
	}
	public boolean lt(RationalExpression r)
	{
            boolean isLessThan =false;
            if((r instanceof RationalNumber)&&((((double)this.numerator)/((double)this.denominator))<(((double)r.getNumerator())/(((double)r.getDenominator())))))
            {
               isLessThan=true;
            }
            return isLessThan;
	}
	public boolean eq(RationalExpression r)
	{
            boolean eq =false;
            if((r instanceof RationalNumber)&&((((double)this.numerator)/((double)this.denominator))==(((double)r.getNumerator())/(((double)r.getDenominator())))))
            {
               eq=true;
            }
            return eq;
	}
	public boolean ge(RationalExpression r)
	{
            boolean ge =false;
            if((r instanceof RationalNumber)&&((this.eq(r))||(this.gt(r))))
            {
               ge=true;
            }
            return ge; 
	}
	public boolean le(RationalExpression r)
	{
            boolean le =false;
            if((r instanceof RationalNumber)&&((this.eq(r))||(this.lt(r))))
            {
               le=true;
            }
            return le; 
	}
	public String toString()
	{
		String returnString = " " + numerator + "/" + denominator; 
		return returnString;
	}


}
    


package project2;

/**
 *
 * @author Joel Salisbury
 */
public interface RationalExpression {
	
	/**
	 * Calculate the result of this RationalExpression + r
	 * @param r
	 * @return
	 */
    public RationalExpression add(RationalExpression r);
    
    /**
	 * Calculate the result of this RationalExpression - r
	 * @param r
	 * @return
	 */
	public RationalExpression sub(RationalExpression r);
	
	/**
	 * Calculate the result of this RationalExpression * r
	 * @param r
	 * @return
	 */
	public RationalExpression mlt(RationalExpression r);
	
	/**
	 * Calculate the result of this RationalExpression / r
	 * @param r
	 * @return
	 */
	public RationalExpression div(RationalExpression r);
	
	/**
	 * Determines whether this RationalExpression is greater
	 *  than r
	 * @param r
	 * @return
	 */
	public boolean gt(RationalExpression r);
	
	/**
	 * Determines whether this RationalExpression is less
	 *  than r
	 * @param r
	 * @return
	 */
	public boolean lt(RationalExpression r);
	
	/**
	 * Determines whether this RationalExpression is equal
	 *  to r
	 * @param r
	 * @return
	 */
	public boolean eq(RationalExpression r);
	
	/**
	 * Determines whether this RationalExpression is greater
	 *  than or equal to r
	 * @param r
	 * @return
	 */
	public boolean ge(RationalExpression r);
	
	/**
	 * Determines whether this RationalExpression is less
	 *  than r
	 * @param r
	 * @return
	 */
	public boolean le(RationalExpression r);
	
	/**
	 * returns the denominator of the RationalExpression
	 *  than r
	 * @param r
	 * @return
	 */
	public int getDenominator();
	
	/**
	 * returns the numerator of the RationalExpression
	 *  than r
	 * @param r
	 * @return
	 */
	public int getNumerator();
}

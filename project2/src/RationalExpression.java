/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author joelsalisbury
 */
public interface RationalExpression {
    public RationalExpression add(RationalExpression r);
	public RationalExpression sub(RationalExpression r);
	public RationalExpression mlt(RationalExpression r);
	public RationalExpression div(RationalExpression r);
	public boolean gt(RationalExpression r);
	public boolean lt(RationalExpression r);
	public boolean eq(RationalExpression r);
	public boolean ge(RationalExpression r);
	public boolean le(RationalExpression r);
	public int getDenominator();
	public int getNumerator();
}

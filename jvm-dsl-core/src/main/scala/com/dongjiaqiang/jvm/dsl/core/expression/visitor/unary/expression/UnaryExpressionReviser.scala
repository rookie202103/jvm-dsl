package com.dongjiaqiang.jvm.dsl.core.expression.visitor.unary.expression

import com.dongjiaqiang.jvm.dsl.api.expression.visitor.ExpressionVisitor
import com.dongjiaqiang.jvm.dsl.api.expression.visitor.unary.expression.UnaryExpressionVisitor
import com.dongjiaqiang.jvm.dsl.api.expression._

trait UnaryExpressionReviser extends UnaryExpressionVisitor[Expression] {

  private def revise(unaryExpression: UnaryExpression,
                     visitor: ExpressionVisitor[Expression],
                     reviser: Expression ⇒ UnaryExpression): Expression = {
    val newChild = visitor.visit( unaryExpression.child )
    if (newChild != unaryExpression.child) {
      reviser.apply( newChild )
    } else {
      unaryExpression
    }
  }

  override def visit(negate: Negate, visitor: ExpressionVisitor[Expression]):Expression={
      revise(negate,visitor,e⇒Negate(e))
  }

  override def visit(opposite: Opposite, visitor: ExpressionVisitor[Expression]):Expression={
    revise(opposite,visitor,e⇒ Opposite(e))
  }

  override def visit(cast: Cast,visitor: ExpressionVisitor[Expression]):Expression={
    revise(cast,visitor,e⇒ Cast(e,cast.castType))
  }

  override def visit(instanceof: Instanceof,visitor: ExpressionVisitor[Expression]):Expression={
    revise(instanceof,visitor,e⇒Instanceof(e,instanceof.judgeType))
  }

  override def visit(paren: Paren,visitor: ExpressionVisitor[Expression]):Expression={
    revise(paren,visitor,e⇒Paren(e))
  }
}

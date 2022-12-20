package com.dongjiaqiang.jvm.dsl.core.expression.generator

import com.dongjiaqiang.jvm.dsl.core.JvmDslParserParser.{ExpressionContext ⇒ ExprContext}
import com.dongjiaqiang.jvm.dsl.core.expression.Expression
import com.dongjiaqiang.jvm.dsl.core.scope.Scope
import org.antlr.v4.runtime.RuleContext

case class ExpressionContext(currentExpressionIndex:Int, contextScope:Scope, topScope:Scope)
trait IExpressionGenerator[T<:RuleContext,R<:Expression] {
    def generate(expressionContext:ExpressionContext,
                 ruleContext: T):R
}

object ExpressionGenerator extends IExpressionGenerator[ExprContext,Expression]{
    override def generate(expressionContext:ExpressionContext,
                          ruleContext: ExprContext): Expression = {
        if(ruleContext.lambdaExpression()!=null){
            LambdaGenerator.generate(expressionContext,ruleContext.lambdaExpression())
        }else{
            OrGenerator.generate(expressionContext,ruleContext.conditionalOrExpression())
        }
    }
}
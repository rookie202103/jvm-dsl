package com.dongjiaqiang.jvm.dsl.core.`type`

import com.dongjiaqiang.jvm.dsl.core.JvmDslParserParser._

trait DslType {
  val name: String
}

abstract class NumberDslType extends DslType


import com.dongjiaqiang.jvm.dsl.core.JvmDslParserParser.TypeContext

object DslType {

  import scala.collection.convert.ImplicitConversionsToScala._

  def unapply(typeContext: TypeContext): DslType = {
    typeContext match {
      case _: IntTypeContext ⇒ IntType
      case _: LongTypeContext ⇒ LongType
      case _: FloatTypeContext ⇒ FloatType
      case _: DoubleTypeContext ⇒ DoubleType
      case _: StringTypeContext ⇒ StringType
      case _: CharTypeContext ⇒ CharType
      case context: ListTypeContext ⇒
        new ListType( unapply( context.`type`( ) ) )
      //      case context: ArrayTypeContext ⇒
      //       new ArrayType( unapply( context ) )
      case context: SetTypeContext ⇒
        new SetType( unapply( context.`type`( ) ) )
      case context: MapTypeContext ⇒
        new MapType( unapply( context.`type`( 0 ) ), unapply( context.`type`( 1 ) ) )
      case context: TupleTypeContext ⇒
        new TupleType( context.`type`( ).map( `type` ⇒ unapply( `type` ) ).toArray )
      case context: OptionTypeContext ⇒
        new OptionType( unapply( context.`type`( ) ) )
      case context: FutureTypeContext ⇒
        new FutureType( unapply( context.`type`( ) ) )
      case context: LambdaTypeContext ⇒
        new LambdaType( Some( unapply( context.`type`( ).head ) ), unapply( context.`type`.last ) )
      case context: SupplierTypeContext ⇒
        new LambdaType( None, unapply( context.`type`( ) ) )
      case context: ParameterizedClassTypeContext ⇒
        new ClazzType( context.clazzType( ).IDENTIFIER( ).getText, context.`type`( ).map( unapply ).toArray )
      case context: ClassTypeContext ⇒
        if (context.clazzType( ).IDENTIFIER( ).getText == "Unit") {
          UnitType
        } else if (context.clazzType( ).IDENTIFIER( ).getText == "Any") {
          AnyType
        } else {
          new ClazzType( context.clazzType( ).IDENTIFIER( ).getText, Array( ) )
        }
    }
  }
}

//base type
object IntType extends NumberDslType {
  override val name: String = "Int"

}

object LongType extends NumberDslType {
  override val name: String = "Long"

}

object FloatType extends NumberDslType {
  override val name: String = "Float"

}

object DoubleType extends NumberDslType {
  override val name: String = "Double"

}

object StringType extends DslType{
  override val name: String = "String"

}

object CharType extends DslType{
  override val name: String = "Char"

}

object ByteType extends DslType{
  override val name: String = "Byte"

}

object BoolType extends DslType {
  override val name: String = "Bool"
}

object UnResolvedType extends DslType {
  override val name: String = "UnResolved"
}

object AnyType extends DslType {
  override val name: String = "Any"
}

object UnitType extends DslType {
  override val name: String = "Unit"
}

//collection type
class ListType(val valueType: DslType) extends DslType {
  override val name: String = "List"

  override def equals(obj: Any): scala.Boolean =
    obj match {
      case listType: ListType ⇒ valueType == listType.valueType
      case _ ⇒ false

    }
}

class SetType(val valueType:DslType) extends DslType {
  override val name: String = "Set"

  override def equals(obj: Any): scala.Boolean =
    obj match {
      case setType: SetType ⇒ valueType == setType.valueType
      case _ ⇒ false
    }

}

class MapType(val keyType:DslType, val valueType:DslType) extends DslType {
  override val name: String = "Map"

  override def equals(obj: Any): scala.Boolean =
    obj match {
      case mapType: MapType ⇒ valueType == mapType.valueType && keyType == mapType.keyType
      case _ ⇒ false
    }
}

class OptionType(val valueType:DslType) extends DslType{
  override val name: String = "Option"

  override def equals(obj: Any): scala.Boolean =
    obj match {
      case option: OptionType ⇒ valueType equals  option.valueType
      case _ ⇒ false
    }


}

class ArrayType(val valueType: DslType) extends DslType {
  override val name: String = "Array"

  override def equals(obj: Any): scala.Boolean =
    obj match {
      case array: ArrayType ⇒ valueType == array.valueType
      case _ ⇒ false
    }
}

class EitherType(val leftType: DslType, val rightType: DslType) extends DslType {
  override val name: String = "Either"

  override def equals(obj: Any): Boolean = {
    obj match {
      case eitherType: EitherType ⇒
        eitherType.leftType == leftType && eitherType.rightType == rightType
      case _ ⇒ false
    }
  }
}

class TupleType(val valueTypes: Array[DslType]) extends DslType {
  override val name: String = "Tuple"

  override def equals(obj: Any): scala.Boolean =
    obj match {
      case tupleType: TupleType ⇒
        valueTypes.sameElements( tupleType.valueTypes )
      case _ ⇒ false
    }
}

class FutureType(val valueType: DslType) extends DslType {
  override val name: String = "Future"

  override def equals(obj: Any): scala.Boolean =
    obj match {
      case futureType: FutureType ⇒
        valueType == futureType.valueType
      case _ ⇒ false
    }
}

class TryType(val valueType: DslType) extends DslType {
  override val name: String = "Try"

  override def equals(obj: Any): scala.Boolean =
    obj match {
      case tryType: TryType ⇒
        valueType == tryType.valueType
      case _ ⇒ false
    }
}

class LambdaType(val inputType: Option[DslType], val outputType: DslType) extends DslType {
  override val name: String = "Lambda"

  override def equals(obj: Any): scala.Boolean =
    obj match {
      case lambdaType: LambdaType ⇒
        lambdaType.inputType == inputType && outputType == lambdaType.outputType
      case _ ⇒ false
    }
}

//clazzType
class ClazzType(val clazzName:String,val valueTypes:Array[DslType]) extends DslType {
  override val name: String = "Clazz"

  override def equals(obj: Any): scala.Boolean =
    obj match {
      case clazzType: ClazzType ⇒ clazzType.clazzName == clazzName &&
        valueTypes.sameElements(clazzType.valueTypes)
      case _ ⇒ false
    }
}






package inheritance

object TraitMixin extends App {

  object Single {

    class A
    class B extends A
  }

  object Hierarchical {

    class A
    class B extends A
    class C extends B
  }

  object IllegalMultipleInheritance {

    class A
    class B

    //    class C extends A with B Diamond problem
  }

  object MultipleInheritance {

    trait A
    trait B

    trait C

    class X extends A with B

    // first class with
    class Y extends X with C with A with B with Serializable
    class Y1 extends X with A with C with B with Serializable
//    class Y2 extends A with X with C with B with Serializable
  }

  object AnonymousObject {

    trait A {

      def name: String
    }

//    val a = new A

    val a: A = new A {
      override def name: String = "A"
    }
  }

  object Restricted {

    trait A {

      def name: String

      def rollNumber: Int = 23
    }

    trait B { self: A =>

      override def name: String = "B"

      def roll: Int

      println(rollNumber)

    }

    class C extends A with B {
      override def roll: Int = 34
    }
  }

  object Mixin {

    trait A {

      def name: String
    }

    trait B extends A {

      override def name: String = "B"
    }

    trait C extends A {

      override def name: String = "C"
    }

    trait D extends A {

      override def name: String = "D"
    }

    class X extends A with C with D with B

    class X1 extends A with B

    val x = new X

    val x1: A = new X1

    val x2 = new A with B
  }

  println(AnonymousObject.a.name)

  println(Mixin.x.name)

  println(Mixin.x1.name)
}

package com.invillia.reinvent;

import org.junit.jupiter.api.Test;

public class OOPCourse {

    /**
     * Vamos criar um BO e instanciar ele
     */
    @Test
    public void definingClassAndInstantiating() {

        Product product = new Product(
                null,
                null,
                null
        );

        assert product.getSku() == null;

        product.setSku("123456789");

        assert product.getSku() != null;
        assert product.getSku().equals("123456789");

        Product otherProduct = new Product(
                "1234567890",
                "Meu celular quebrado",
                "O celular está quebrado, mas ainda é bom. Se não tem interesse não incomode"
        );

        assert otherProduct.getSku() != null;
        assert otherProduct.getName() != null;
        assert otherProduct.getDescription() != null;

        assert otherProduct.getSku().equals("1234567890");

        otherProduct.setName("Meu celular topizera");

        assert otherProduct.getName().equals("Meu celular topizera");

        assert !otherProduct.equals(product);
    }

    /**
     * Vamos definir atributos privados, ancapsular-los em métodos de acesso e acessar-los
     */
    @Test
    public void definingAttributesAndAccessMethods() {

        assert true;
    }

    /**
     * Vamos definir métodos e invocar-los
     */
    @Test
    public void definingMethodsAndInvoking() {

        assert true;
    }

    /**
     * Vamos definir atributos e variáveis locais e manipular-las
     */
    @Test
    public void definingAttributesAndVariables() {

        assert true;
    }

    /**
     * Vamos definir uma interface e implementar-la e acessar seus métodos por polimorfismo
     */
    @Test
    public void definingInterfaceAndImplementing() {

        assert true;
    }

    /**
     * Vamos definir uma sub-classe, instaciar-la e acessar seus médotos por polimorfismo
     */
    @Test
    public void definingSubClassAndInstantiating() {

        assert true;
    }

    /**
     * Vamos definir uma classe abstrata e extender ela
     */
    @Test
    public void definingAbstractClassAndExtending() {

        assert true;
    }

    /**
     * Vamos sobrescrever métodos de uma super-classe e invocar o método da super-classe
     */
    @Test
    public void overridingMethodsAndInvokingSuperClassMethod() {

        assert true;
    }

    /**
     * Vamos definir uma classe final e um método final
     */
    @Test
    public void definingFinalClassAndMethod() {

        assert true;
    }

    /**
     * Vamos definir métodos privados, protegidos, privados ao pacote e publicos e invocar-los
     */
    @Test
    public void definingMethodsWithDifferentVisibility() {

        assert true;
    }

    /**
     * Vamos definir um método default em uma interface
     */
    @Test
    public void definingDefaultMethodOnInterfaceAndInvoking() {

        assert true;
    }

    /**
     * Vamos definir variaveis estáticas, constantes locais e globais
     */
    @Test
    public void definingStaticVariablesAndConstants() {

        assert true;
    }

    /**
     * Vamos definir métodos estáticos e invoca-los
     */
    @Test
    public void  definingStaticMethodAndInvoking() {

        assert true;
    }
}

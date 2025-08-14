Exemplos **ruins** de uso de herança (anti-patterns clássicos):

---

### **1. Herança profunda e difícil de manter**

```java
class Animal { }
class Mamifero extends Animal { }
class Felino extends Mamifero { }
class Gato extends Felino { }
class GatoSiames extends Gato { }
```

📌 Problema:

* Cada mudança em `Animal` pode quebrar tudo abaixo.
* Muito difícil de entender e dar manutenção.
  ✅ Correção: reduzir níveis de herança e usar interfaces/composição para comportamentos.

---

### **2. Sobrescrever para "desligar" comportamento da superclasse**

```java
class Conta {
    public void sacar(double valor) {
        System.out.println("Sacando: " + valor);
    }
}

class ContaSomenteDeposito extends Conta {
    @Override
    public void sacar(double valor) {
        throw new UnsupportedOperationException("Não pode sacar");
    }
}
```

📌 Problema:

* A subclasse herda um método que não deveria ter.
* Violação do **Liskov Substitution Principle**.
  ✅ Correção: separar em interfaces (`ContaComSaque`, `ContaSomenteDeposito`).

---

### **3. Duplicação de lógica entre subclasses**

```java
class ClienteComum {
    public void solicitarEmprestimo() {
        System.out.println("Você não tem direito a empréstimo.");
    }
}

class ClienteEstudante {
    public void solicitarEmprestimo() {
        System.out.println("Você não tem direito a empréstimo.");
    }
}
```

📌 Problema:

* Mesmo código repetido em várias classes.
  ✅ Correção: usar **Strategy** ou composição.

---

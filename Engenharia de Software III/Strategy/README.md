# 🧩 Strategy Pattern

O **Strategy** é um padrão de projeto comportamental que permite **definir uma família de algoritmos**, encapsulá-los em **classes separadas** e torná-los **intercambiáveis** em tempo de execução.

Em outras palavras: ele ajuda a **eliminar estruturas rígidas com `if` ou herança excessiva**, tornando o sistema **mais flexível e fácil de expandir**.

---

# 😿 Problema

<div align="center">

![dnd](https://github.com/user-attachments/assets/383ec42e-fad5-4289-beea-27471e490048)

</div>

**Dungeons & Dragons (D&D)** é um RPG de mesa onde os jogadores criam personagens com diferentes **classes** — como **Bardo**, **Mago**, **Paladino** e **Monge** — para viver aventuras em um mundo de fantasia.

No sistema de regras, existe o conceito de **multiclasse**, que permite a um personagem combinar habilidades de mais de uma classe (por exemplo, ser **Bardo/Mago**).

Agora imagine que você está programando um sistema de D&D e cria uma classe `Personagem` com subclasses como `Bardo`, `Mago`, `Paladino` e assim por diante.

Com o tempo, surgem combinações como `BardoMago`, `PaladinoMonge`, `MagoPaladino`...
Cada nova combinação exige **novas subclasses** com **métodos duplicados** e **códigos repetidos**, gerando o chamado **“explosão de classes”** — um **anti-pattern** clássico quando se abusa de **herança**.

Além disso:

* Qualquer mudança em um dos comportamentos (ex: lançar magia, tocar música, atacar) força alterações em várias classes.
* Corrigir um bug ou ajustar atributos de uma habilidade pode quebrar o código de outro personagem.
* O código se torna rígido e difícil de dar manutenção.

> 🧱 Esse tipo de estrutura monolítica e repetitiva é o “chefe final” da manutenção de código: quanto mais cresce, mais difícil fica de derrotar.

---

# 😸 Solução

O **Strategy Pattern** resolve esse problema **separando os comportamentos** (estratégias) das **classes principais**.

Cada tipo de ação — como **atacar**, **lançar magia**, **esquivar** ou **tocar música** — passa a ser uma **interface** com suas **implementações concretas**.

Assim:

* `Bardo` usa uma estratégia de música (`TocarMusica`) e de ataque (`Atacar`);
* `Mago` usa uma estratégia de magia (`LancarMagia`) e de esquiva (`Esquiva`);
* `BardoMago` apenas **combina as duas estratégias**, sem precisar duplicar código.

Dessa forma, o comportamento do personagem pode ser **trocado dinamicamente**, e o código fica **modular, reutilizável e fácil de estender**.

> ✨ O Strategy permite que o Bardo cante, o Mago conjure e o Paladino lute — tudo isso sem precisar de uma árvore genealógica de classes impossível de manter.

---

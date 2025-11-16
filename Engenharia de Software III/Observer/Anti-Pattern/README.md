# 🐛 Anti-pattern do Observer

O **anti-pattern do Observer** surge quando o mecanismo de notificação entre **Sujeito (Subject)** e **Observadores (Observers)** deixa de ser simples e flexível, passando a gerar **acoplamento excessivo**, **vazamentos de memória** e **complexidade difícil de controlar**.

Ele costuma aparecer em situações como:

- **Observadores que nunca são removidos**
  O sujeito acumula objetos inscritos que já não deveriam mais existir.
  Isso gera consumo excessivo de memória e chamadas desnecessárias.

- **Notificações disparadas com frequência exagerada**
  Cada pequeno evento dispara dezenas (ou centenas) de atualizações, impactando **performance** e causando gargalos no sistema.

- **Dependência da ordem de atualização**
  Alguns observadores passam a depender da atualização de outros para funcionar corretamente, criando comportamento **imprevisível**, difícil de reproduzir e complexo de depurar.

Quando isso acontece, o Observer deixa de ser um padrão que promove **baixo acoplamento** e passa a ser uma fonte de instabilidade.
O resultado: um sistema **difícil de manter**, com bugs sutis, dependências implícitas e comportamento inconsistente.

---


# Nubank interview

 1. Arquitetura Hexagonal
 2. Clean code
 3. TDD
 4. BDD
 5. DDD
 6. DRY
 7. Refactoring
 8. Paradigma Funcional
 9. Clojure
 10. Docker
 11. Kubernetes 

## 1. Arquitetura Hexagonal:

## 2. Clean Code

### Nomes significativos:
 O nome de uma variável, função ou classe deve "responder a todas as grandes questões". 
 Deve dizer por que existe, o que faz e como é usado.
 Se um nome exigir um comentário, ele não revela sua intenção.
 
 ❌ **Forma incorreta** 

     (def d 1) // elapsed time in days.  

 ✅ **Forma correta**    

     (def elapsedTimeInDays 1)


#### Nome de classes:
Classes e objetos devem ter nomes substantivos ou substantivos como *Customer*, *WikiPage*, Account e *AddressParser*. 
Evite palavras como *Manager*, *Processpr*, *Data* ou *Info* no nome de uma classe. 
*Um nome de classe não deve ser um verbo.*]

#### Nomes de métodos:
  
Os métodos devem ter nomes de verbos ou frases verbais, como *postPayment*, *deletePage* ou save. Os *acessadores*, *mutadores* e predicados devem ser nomeados por seu valor e prefixados com *get*, *set*.

Quando os construtores estiverem sobrecarregados, use métodos estáticos de fábrica com nomes que descrevam os argumentos
# Triple A
- Arrange
- Act
- Assert
```mermaid
flowchart LR
A[Arrange<br>Input]-->B(Act<br>White-box)
B-->C[Assert<br>Output]
class A cssClass
```
---
# Test Coverage
- Example with `PromptBinary()`

| Testcases: | y    | Y    | n     | N     | x -> y        |
| ---------- | ---- | ---- | ----- | ----- | ------------- |
| Expected:  | true | true | false | false | retry -> true |

---
# Test Coverage
![Pasted image 20241128113949.png](Pasted%20image%2020241128113949.png)

--- 
# Mockito
> Mockito er et JUnit værktøj som kan bruges til at erstatte afhængigheder, ved at stubbe afhængighederne
---
# Mockito

![Pasted image 20241128114550.png](Pasted%20image%2020241128114550.png)

---
# Mockito
![Pasted image 20241128113949.png](Pasted%20image%2020241128113949.png)
---
# GitHub Actions

> Continous integration (CI) pipeline, er et automatiseret system, der kan køre alle Unit Tests før du merger kode ind i `main` branchen

---
# GitHub Actions

![Pasted image 20241128115647.png](Pasted%20image%2020241128115647.png)
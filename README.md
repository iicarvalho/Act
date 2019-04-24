# Tutorial de compilação e execução do teste (via terminal - linux distro)

* Baixe os arquivos "ActTest.java" e "Order.java" e coloque-os no diretório de sua preferência, desde que ambos estejam no mesmo diretório.
* Abra o terminal, navegue até a pasta que contém os arquivos citados acima e digite "javac ActTest.java" para compilar
* Para executar, digite "java ActTest". O terminal irá aguardar um input e será mostrado o resultado (ou erro) no final.
* Caso a compilação não funcione, é provável que a JDK não esteja instalada em sua máquina. Para instalar utilize o comando "sudo apt-get install default-jdk" e tente novamente.

# Tutorial de execução do teste (via prompt de comandos - windows)

* Baixe a pasta "dist"
* Coloque-a em um diretório de sua preferência
* Abra o prompt de comandos (CMD) e digite 'java -jar "C:\Diretorio\dist\ActTest.jar" ', onde a palavra 'Diretorio' no caminho especificado, é o diretório onde a pasta foi salva. O terminal irá aguardar um input e será mostrado o resultado (ou erro) no final.

# Sobre o teste

**Dificuldades encontradas:**

* Por se tratar de uma linguagem tipada, a manipulação de strings é mais complexa, porém o desenvolvimento não foi comprometido.
* O último caso de testes ficou ambíguo na minha concepção. Não foi informado como deveria ser de fato o tratamento para itens que não podem ser repetidos. Optei por exibir ao usuário uma mensagem padronizada. No caso onde o período é o da manhã, o programa informa "pedidos múltiplos só são possíveis para bebidas". No caso onde o período é o da noite, o programa informa "pedidos múltiplos só são possíveis para batatas".

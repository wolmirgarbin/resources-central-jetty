# resources-central-jetty
Projeto que centralizador de recursos para aplicações web em geral.

Este projeto pode ser utilizado para organizar os recursos de css e js de qualquer aplicação web, permitindo configurar o cache que será aplicado a cada recurso, versão entre outros.

O aplicativo contem o jetty embarcado o que permite rodar em ambiente de desenvolvimento usando o comando:
$ mvn jetty:run

Para o ambiente de produção é gerado apenas um .war que pode ser adicionado a qualquer containner ou usar o próprio jetty para prover o recurso.

# Vantagem

. Separar a camada de aplicação da camada de recursos mantendo.
. Otimizar o css e js usando o plugin do maven para versões em produção.
. Utilizar os recursos para qualquer aplicação a mais que tenha em sua empresa.

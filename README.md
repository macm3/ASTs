# ASTs
if688 ~ 2017.1

Alunos: Higor Cavalcanti [hcmb] e Marcela Azevedo [macm3]

É necessário configurar o ANTLR antes de rodar o projeto.

1. Clique com o botão direito em hcmb_macm3.g4
2. Run As
3. Generate ANTLR Recognizer
3. Clique novamente com o botão direito em hcmb_macm3.g4
4. Run As
5. External Tools
4. Na tela de configurações do External Tools, adicione as seguintes flags aos arguments do arquivo hcmb_macm3.g4

 -o src/main -visitor -listener -encoding UTF-8 -package main

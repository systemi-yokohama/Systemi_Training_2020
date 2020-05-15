[1]
・do...while文命令の末尾には、セミコロンが必要
・while命令がループの先頭で条件式を判定する（前置判定）するのに対して、
do...while命令はループの末尾で判定（後置判定）する。
このため、条件式が最初からfalseである場合に、while命令は一度もループを実行しないが、
do...while命令は最低一度はループを実行する
[2]
for(var a = 1; a < 10; a++){
  for(var i = 1; i < 10; i++){
      var result = i*j;
   System.out.print(result + " ");
  }
}
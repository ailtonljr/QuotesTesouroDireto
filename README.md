# QuotesTesouroDireto

Aplicação para obter os valores dos títulos do Tesouro Direto automaticamente através do KMyMoney.

## Configuração

|Campo|Valor|
| -------------: |:-------------|
|URL: |file:/home/[...]/TesouroDireto.sh %1|
|Símbolo:| ([^\(]+)|
|Preço:| R\$([0-9.]+,\d+)|
|Data:| (\d\d\/\d\d\/\d\d\d\d$)|
|Formato da Data:| %d %m %y|


## Exemplo TesouroDireto.sh

```bash
#!/bin/bash
java -jar /home/[...]/TesouroDiretoQuotes-0.0.1-SNAPSHOT.jar $*
```


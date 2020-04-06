Steps to replay the exception `payload doesn't make sense while simplified=true `  
1. run Provider.java in dubbo-provider  
2. run Consumer.java in dubbo-consumer   
3. see error.log  
`Data length too large: 9437210, max payload: 8388608`, `payload="104857600"` is set in `provider.xml`  
4. setting `simplified=false`, will work normally  
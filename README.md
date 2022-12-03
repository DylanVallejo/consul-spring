#  Spring Boot Msvc Registry and configuration with Consul   

### Inicializando Consul
>Consul nos ayudara como servidor de registro y configuracion durante la elaboracion de nuestros microservicios 
=============
- Inicializar consul en una consola utilizando el comando    
- > consul.exe agent -dev
![image](https://user-images.githubusercontent.com/99937413/205415813-61a8bdc8-afeb-4f89-96e8-f41d1dbef57f.png)
- Una vez ejecutado el comando podremos ver nuestro  servidor de consul en la direccion localhost:8500 
![image](https://user-images.githubusercontent.com/99937413/205416233-abb8fcea-9f4a-4f9b-9a3b-2fff03918e4a.png)


### Dependencias Spring Cloud Consul en microservicios para registro y configuracion 
>Necesitaremos agregar la dependencia   (consul discovery y consul config)  para nuestro microservicio.
=============
-Agregando dependencias en  nuestro archivo pom 
![image](https://user-images.githubusercontent.com/99937413/205416328-99ec27f6-fdc1-4d1a-89ba-52c52356c791.png)
-Agregando la notacion @EnableDiscoveryClient en nuestro clase principal 
![image](https://user-images.githubusercontent.com/99937413/205416408-b0ef1a47-c903-40c8-81e8-ea59719f8642.png)
-Agregando las propiedades para el puerto, nombre y fuente de configuracion desde consul o de manera local en nuestro application.properties 
![image](https://user-images.githubusercontent.com/99937413/205416458-f83d2d20-244d-4380-a9e4-c7bb3e30cc4f.png)
-Ejecutando nuestros microservicios
![image](https://user-images.githubusercontent.com/99937413/205416488-27c3ee3f-1c9c-4fd0-9085-ec82ab7b7ef5.png)
-Consul registrara automaticamente nuestro microservicios y podremos visualizarlo en su interface 
![image](https://user-images.githubusercontent.com/99937413/205416536-6c08f38d-3ac8-4a78-a34d-379d7af07abf.png)


### Archivo bat opcional 
>Ejecutara el servidor de consul e ingresara key/values para la configuracion de los microservicos. 
=============
![image](https://user-images.githubusercontent.com/99937413/205416606-0e7ba999-9db5-46a6-a5ce-84e701b6eac4.png)

-configuraciones ya cargadas en consul 
![image](https://user-images.githubusercontent.com/99937413/205416646-af0c6ae8-f1fb-4df9-a479-414d9f053923.png)


-Obteniendo una configuracion desde consul en el controlador 
![image](https://user-images.githubusercontent.com/99937413/205416673-4c91173d-962c-48a2-848c-efaa859474d7.png)


-Resultado del navegador 
![image](https://user-images.githubusercontent.com/99937413/205416690-f510bf96-28c7-405a-80d4-00a3cb6cdedc.png)


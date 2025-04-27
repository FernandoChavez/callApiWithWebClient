Instrucciones para que funcione Prometheus y Grafana

1.- Descarga "Docker desktop" e instalalo en tu equipo
2.- Manten abierto el software para que el servicio esté corriendo
3.- Importa este proyecto en tu ide favorito (De preferencia IntelliJ)
4.- Abre la terminal y ejecuta el comando "docker compose up" para que ejecute el archivo "docker-compose" y descargues las imagenes de prometheus y grafana
5.- Corre el proyecto
6.- Ahora ya puedes acceder a prometheus y grafana
  -Prometheus: http://localhost:9090/
  -Grafana: http://localhost:3000/

Nota: Si quieres saber mas sobre la configuracion que se hizo en estas 2 herramientas, favor de revisar los archivos "docker-compose" y "config/prometheus/prometheus.yml"

Video de referencia: https://www.youtube.com/watch?v=JnO0Oh9J6Iw

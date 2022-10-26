docker run -d --name oracle -p 1521:1521 -e ORACLE_PASSWORD=admin gvenzl/oracle-xe
docker container logs -f oracle

docker create volume oracle -volume
docker run -d -v oracle-volume:/opt/oracle/oradate oracle -p 1521:1521 -e ORACLE_PASSWORD=admin gvenzl/oracle-xe

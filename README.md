IBM MQ on mac:

https://developer.ibm.com/tutorials/mq-macos-dev/
https://community.ibm.com/community/user/integration/blogs/richard-coppen/2023/06/30/ibm-mq-9330-container-image-now-available-for-appl?utm_source=ibm_developer&utm_content=in_content_link&utm_id=tutorials_mq-connect-app-queue-manager-containers&cm_sp=ibmdev-developer--community
https://developer.ibm.com/tutorials/mq-connect-app-queue-manager-containers/#step-4-put-and-get-a-message-using-the-mq-console

install podman and start it by running the following commands: 
podman machine init
podman machine start

podman images
podman volume create qm1data
podman run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --volume qm1data:/mnt/mqm --publish 1414:1414 --publish 9443:9443 --detach --env MQ_APP_USER=app --env MQ_APP_PASSWORD=passw0rd --env MQ_ADMIN_USER=admin --env MQ_ADMIN_PASSWORD=passw0rd --name QM1 localhost/ibm-mqadvanced-server-dev:9.4.1.1-arm64

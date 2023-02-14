#!/bin/bash

set -e

PROFILE=dev
if [ $# -ge 1 ]; then
    PROFILE=$1
fi

# set image name
IMAGE_NAME=$(basename `pwd`)
IMAGE_TAG=$(date +%s)-`git rev-parse --short HEAD`

# set module name if multi mudule projects
MODULE_NAME=$(basename `pwd`)

DOCKER_NS='xixitime'
DOCKER_REGISTRY='registry.cn-beijing.aliyuncs.com'
HELM_CHART='xixitime/java-app'
HELM_RELEASE_NAME=${IMAGE_NAME}"-"${PROFILE}
HELM_NS=${PROFILE}

#VALUES_FILE="values-${PROFILE}.yaml"

WORKDIR=`pwd`

echo "workdir = ${WORKDIR}"
echo "image_name = ${IMAGE_NAME}"
echo "image_tag = ${IMAGE_TAG}"
echo "module_name = ${MODULE_NAME}"
echo "docker_ns = ${DOCKER_NS}"
echo "docker_registry = ${DOCKER_REGISTRY}"
echo "helm_chart = ${HELM_CHART}"
echo "helm_release_name = ${HELM_RELEASE_NAME}"
echo "helm_namespace = ${PROFILE}"
#echo "values_file = ${VALUES_FILE}"

# 检查文件是否齐全
if [ ! -f "Dockerfile" ]; then
    echo "error: Dockerfile not found" >&2
    exit 1
fi

#if [ ! -f ${VALUES_FILE} ]; then
#    echo "error: ${VALUES_FILE} not found" >&2
#    exit 1
#fi

export LANG=zh_CN.UTF-8
export LC_ALL=zh_CN.UTF-8

if [ -n "${MODULE_NAME}" ]; then
    cd ../
    mvn clean package -U -Dmaven.test.skip=true -T 2.0C -pl ${MODULE_NAME} -am
    cd ${MODULE_NAME}
else
    mvn clean package -U -Dmaven.test.skip=true -T 2.0C
fi

mkdir target/dist
cd target/dist
jar -xf ../*.jar
cp -R ../../../skywalking ./skywalking
cd ../../

docker build -t ${DOCKER_NS}/${IMAGE_NAME}:${IMAGE_TAG} .
docker tag ${DOCKER_NS}/${IMAGE_NAME}:${IMAGE_TAG} ${DOCKER_REGISTRY}/${DOCKER_NS}/${IMAGE_NAME}:${IMAGE_TAG}
docker push ${DOCKER_REGISTRY}/${DOCKER_NS}/${IMAGE_NAME}:${IMAGE_TAG}

#kubectl config use-context xxt-cluster-${PROJECT_PROFILE}

#if [ "install" == "${CMD}" ]; then
#    helm install --name ${HELM_RELEASE_NAME} ${HELM_CHART} --namespace=${HELM_NS} --set-string image.tag=${IMAGE_TAG} --values ${VALUES_FILE} --debug
#elif [ "upgrade" == "${CMD}" ]; then
TARGET_VALUES_FILE=/data/home/deployer/helm/values/${IMAGE_NAME}-${IMAGE_TAG}-${VALUES_FILE}
#scp ${VALUES_FILE} deployer@182.92.116.81:${TARGET_VALUES_FILE}
#ssh deployer@182.92.116.81 "helm upgrade --install ${HELM_RELEASE_NAME} ${HELM_CHART} --namespace=${HELM_NS} --set-string image.tag=${IMAGE_TAG} --values ${TARGET_VALUES_FILE} --debug"
#else
#    echo "unkown cmd ${CMD}" >&2
#    exit 1
#fi

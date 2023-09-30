def call(String project,String tag,String user,String accountId,String region){
    withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'PASSWORD', usernameVariable: 'USER')]) {
    sh """
     docker login -u $USER -p $PASSWORD
     docker image push  ${user}/${project}:${tag}
     docker image push  ${user}/${project}:latest
    """
}


withCredentials([usernamePassword(credentialsId: 'aws-cred-01', passwordVariable: 'AWS_SECRET_ACCESS_KEY', usernameVariable: 'AWS_ACCESS_KEY_ID')]) {
sh """
aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin  ${accountId}.dkr.ecr.${region}.amazonaws.com
 docker image push image tag  ${user}/${project} ${accountId}.dkr.ecr.${region}.amazonaws.com/${project}:${tag}
"""
}


}
def call(String project,String tag,String user){
    withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'PASSWORD', usernameVariable: 'USER')]) {
    sh """
     docker login -u $USER -p $PASSWORD
        docker image push  ${user}/${project}:${tag}
         docker image push  ${user}/${project}:latest
    """
}
}
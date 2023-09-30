def call(String project,String tag,String user){
    sh """
       docker image build -t ${user}/${project} . 
       docker image tag  ${user}/${project}  ${user}/${project}:${tag}
       docker image tag  ${user}/${project}  ${user}/${project}:latest
    """
}
def call(String project,String tag,String user,String accountId.String region){
    sh """
       docker image build -t ${user}/${project} . 
       docker image tag  ${user}/${project}  ${user}/${project}:${tag}
       docker image tag  ${user}/${project}  ${user}/${project}:latest
       docker image tag  ${user}/${project} ${accountId}.dkr.ecr.${accountId}.amazonaws.com/${project}:${tag}
    """
}
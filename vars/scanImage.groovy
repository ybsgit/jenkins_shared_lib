def call(String project,String tag,String user){
   sh """
        trivy image ${user}/${project}:latest > scan.txt
        cat scan.txt
    """
}
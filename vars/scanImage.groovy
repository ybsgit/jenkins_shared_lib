def call(){
   sh """
        trivy image ${user}/${project}:latest > scan.txt
        cat scan.txt
    """
}
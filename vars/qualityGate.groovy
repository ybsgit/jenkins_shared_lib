def call(cred){
    waitForQualityGate abortPipeline: false, credentialsId: cred
}

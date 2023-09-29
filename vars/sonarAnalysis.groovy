def call(cred){
withSonarQubeEnv(credentialsId: cred) {
      sh 'mvn clean package sonar:sonar'
}
 
}
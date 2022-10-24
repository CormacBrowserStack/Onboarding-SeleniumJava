pipeline {
	agent any
	tools{
	}
	stages {
		stage("setup"){
			steps {
				browserstack(credntialsId: '50e72f61-f2da-4397-b6cb-92e537654425'){
				}
				// Enable reporting in Jenkins
            			browserStackReportPublisher 'automate'
			}
		}
		stage("test"){
			steps {
				echo 'Running the application'
				maven('Maven') {
				sh 'mvn test -P sample-test'
				}
			}
		}
		stage("deploy"){
			steps {
				echo 'No application to deploy, this is just for running tests'
			}
		}
	}
}

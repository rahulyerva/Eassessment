package com.example

class Pipeline {
    def script
    def configurationFile

    Pipeline(script, configurationFile) {
        this.script = script
        this.configurationFile = configurationFile
    }
	
    def execute() {
//    ===================== Your Code Starts Here =====================
//    Note : use "script" to access objects from jenkins pipeline run (WorkflowScript passed from Jenkinsfile)
//           for example: script.node(), script.stage() etc

//    ===================== Parse configuration file ==================
		def data = readYaml file: 'config.yaml'
//    ===================== Run pipeline stages =======================
		node('master') {
			stage('Checkout'){
				checkout scm
			}
			stage('Build') {
				sh "cd ./project
				sh "data.build.buildCommand"
			}
		}
//    ===================== End pipeline ==============================
		

    }
}

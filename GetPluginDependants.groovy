/*** BEGIN META {
  "name" : "Get plugin dependants",
  "comment" : "Get plugins that are dependant on another plugin.",
  "parameters" : [ 'pluginName' ],
  "authors" : [
    { name : "CloudBees Support" }
  ]
} END META**/

// NOTES:
// pluginName: the name of the plugin for which dependants should be gathered
// Sourced from https://support.cloudbees.com/hc/en-us/articles/216351528-How-do-I-analyse-plugins-and-dependencies-for-an-instance-

pluginName = 'config-file-provider'

jenkins.model.Jenkins.instance.getPluginManager().getPlugins()
    .findAll {
        plugin -> plugin.getDependencies().find {
            dependency -> pluginName.equals(dependency.shortName)
        }
    }.each {
        println "${it.getShortName()} (${it.getVersion()})"
    }

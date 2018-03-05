// import hudson.tasks.Maven
// import hudson.tasks.Maven.MavenInstallation;
// import hudson.tools.InstallSourceProperty;
// import hudson.tools.ToolProperty;
// import hudson.tools.ToolPropertyDescriptor
// import hudson.tools.ZipExtractionInstaller;
// import hudson.util.DescribableList
// import jenkins.model.Jenkins;

// def extensions = Jenkins.instance.getExtensionList(Maven.DescriptorImpl.class)[0]

// List<MavenInstallation> installations = []

// mavenToool = ['name': 'maven3', 'url': 'file:/var/jenkins_home/downloads/apache-maven-3.5.2-bin.tar.gz', 'subdir': 'apache-maven-3.5.2']

// println("Setting up tool: ${mavenToool.name} ")

// def describableList = new DescribableList<ToolProperty<?>, ToolPropertyDescriptor>()
// def installer = new ZipExtractionInstaller(mavenToool.label as String, mavenToool.url as String, mavenToool.subdir as String);

// describableList.add(new InstallSourceProperty([installer]))

// installations.add(new MavenInstallation(mavenToool.name as String, "", describableList))

// extensions.setInstallations(installations.toArray(new MavenInstallation[installations.size()]))
// extensions.save()

import hudson.tasks.Maven.MavenInstallation;
import hudson.tools.InstallSourceProperty;
import hudson.tools.ToolProperty;
import hudson.tools.ToolPropertyDescriptor;
import hudson.util.DescribableList;

def mavenDesc = jenkins.model.Jenkins.instance.getExtensionList(hudson.tasks.Maven.DescriptorImpl.class)[0]

def isp = new InstallSourceProperty()
def autoInstaller = new hudson.tasks.Maven.MavenInstaller("3.5.2")
isp.installers.add(autoInstaller)

def proplist = new DescribableList<ToolProperty<?>, ToolPropertyDescriptor>()
proplist.add(isp)

def installation = new MavenInstallation("maven3", "", proplist)

mavenDesc.setInstallations(installation)
mavenDesc.save()
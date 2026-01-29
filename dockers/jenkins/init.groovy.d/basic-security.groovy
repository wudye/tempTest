import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()
if (instance.getSecurityRealm() == null || !(instance.getSecurityRealm() instanceof hudson.security.HudsonPrivateSecurityRealm)) {
    def user = System.getenv("JENKINS_USER") ?: "admin"
    def pass = System.getenv("JENKINS_PASS") ?: "admin"
    def realm = new HudsonPrivateSecurityRealm(false)
    realm.createAccount(user, pass)
    instance.setSecurityRealm(realm)
    def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
    instance.setAuthorizationStrategy(strategy)
    instance.save()
}
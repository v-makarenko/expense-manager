cd ~/Documents
sudo apt-get update

# install git and clone the project	

sudo apt-get install maven git
git clone https://github.com/v-makarenko/expense-manager

# install jdk

sudo apt-get install python-software-properties
sudo add-apt-repository ppa:webupd8team/java
# press enter
sudo apt-get update
sudo apt-get install oracle-java8-installer
# press enter
# press left
# press enter

# download and setup jboss

wget http://download.jboss.org/jbossas/7.1/jboss-as-7.1.1.Final/jboss-as-7.1.1.Final.zip
sudo unzip jboss-as-7.1.1.Final.zip -d /opt
sudo adduser jboss
sudo chown -fR jboss.jboss /opt/jboss-as-7.1.1.Final/
sudo su - jboss
cd /opt/jboss-as-7.1.1.Final/bin
./add-user.sh
# press enter 
# admin admin admin2 admin2 yes yes
cd ~/Documents/expense-manager

# install mysql
sudo apt-get install mysql-server mysql-client
# root "enter" root "enter"

# add jdbc driver
wget http://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-5.1.34.zip
unzip mysql-connector-java-5.1.34.zip
sudo cp mysql-connector-java-5.1.34/mysql-connector-java-5.1.34-bin.jar /opt/jboss-as-7.1.1.Final/standalone/deployments/mysql-connector-java-5.1.34-bin.jar

# setup the datasource
sed '/<datasources>/a  <datasource jndi-name="java:/expensesDS" pool-name="expensesDS"><connection-url>jdbc:mysql://localhost:3306/root</connection-url><driver>com.mysql</driver><transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation><pool><min-pool-size>10</min-pool-size><max-pool-size>100</max-pool-size><prefill>true</prefill></pool><security><user-name>root</user-name><password>root</password></security><statement><prepared-statement-cache-size>32</prepared-statement-cache-size><share-prepared-statements/></statement></datasource><drivers><driver name="com.mysql" module="com.mysql"><xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class></driver></drivers>' /opt/jboss-as-7.1.1.Final/standalone/configuration/standalone.xml

# deploy the app
sudo cp et-ear/target/et.ear.ear /opt/jboss-as-7.1.1.Final/standalone/deployments/et.ear

# start the server
sudo su - jboss
cd /opt/jboss-as-7.1.1.Final/bin
./standalone.sh



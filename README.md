[![](https://jitpack.io/v/Skjolberg/SimpleBlockRegenAPI.svg)](https://jitpack.io/#Skjolberg/SimpleBlockRegenAPI)
# SimpleBlockRegenAPI

An intuitive API to support SimpleBlockRegen Premium

## Prerequisites
- Java 8
- Minecraft version: 1.8 - 1.19

## Downloads
- [Spigot](https://www.spigotmc.org/resources/simpleblockregen-premium-%E2%9C%85-create-automatic-regeneration-regions-%E2%9B%8F%EF%B8%8F.103286/)
- [DevBuilds](https://discord.gg/pHFYxRUkAP)

## Links

- [Discord](https://discord.gg/pKZb4nYy97)
- [Wiki](https://github.com/Skjolberg/SimpleBlockRegen/wiki)

[![Discord](https://img.shields.io/discord/955564646708961442?label=Discord)](https://discord.gg/pKZb4nYy97)

## How to include the API:
Maven:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.Skjolberg</groupId>
        <artifactId>SimpleBlockRegenAPI</artifactId>
        <version>0.0.1</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```
Gradle (groovy):
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    compileOnly "com.github.Skjolberg:SimpleBlockRegenAPI:0.0.1"
}
```
Gradle (kotlin):
```kotlin
repositories {
    maven("https://jitpack.io")
}
dependencies {
    compileOnly("com.github.Skjolberg:SimpleBlockRegenAPI:0.0.1")
}
```

## Implementing SimpleBlockRegen Premium
Implementing SBR is quite simple. 
It requires getting the service from the Bukkit ServiceManager. 
This example is taken from the Vault API. 
See the example below:

```java
package net.shibacraft.simpleplugin;

import region.net.shibacraft.simpleblockregen.RegionManagerImpl;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import net.shibacraft.simpleplugin.module.MainModule;

public class SimplePlugin extends JavaPlugin {

    public static SimplePlugin plugin;
    private MainModule mainModule;
    private static RegionManagerImpl regionManager;

    @Override
    public void onEnable() {
        SimplePlugin.plugin = this;

        mainModule = new MainModule(this);
        mainModule.load();

        if (setupRegionManager()) {
            // logic
        }
        

    }

    @Override
    public void onDisable() {
        mainModule.unload();
    }

    private boolean setupRegionManager() {
        if (getServer().getPluginManager().getPlugin("SimpleBlockRegen") == null) return false;

        RegisteredServiceProvider<RegionManagerImpl> rsp = getServer().getServicesManager().getRegistration(RegionManagerImpl.class);
        if (rsp == null) return false;

        regionManager = rsp.getProvider();
        return true;
    }
    
    public static RegionManagerImpl getRegionManager() {
        return regionManager;
    }

}
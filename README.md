# 大貂核心 (DiaoCore)

[![作者](https://img.shields.io/badge/作者-止-blue.svg)](https://github.com/ZHI-CCC)
[![团队](https://img.shields.io/badge/团队-大貂Team-orange.svg)](https://github.com/Giant-Diao-Team)
[![版本](https://img.shields.io/badge/版本-1.0.0-brightgreen.svg)](https://github.com/Giant-Diao-Team/DiaoCore)  
本插件备注由 CodeGeeX 生成 （自动生成备注是真tmd好用）

一个为 Minecraft Spigot 服务器设计的核心功能插件，旨在提供一系列基础的、通用的功能和工具，以减少其他插件开发时的重复工作，并作为 **大貂团队** 系列插件的基础支撑。

## ✨ 特色功能

- **🚀 核心功能抽象**: 抽象化并封装了如客户端通信等频繁使用的任务，方便其他插件直接调用，专注于核心业务逻辑。
- **⚡️ 轻量高效**: 插件本身设计简洁，功能模块化，最大程度减少资源占用，保证服务器流畅运行。
- **📝 开发友好**: 旨在提供一个稳固的骨架，方便其他开发者在此基础上进行扩展，共同构建更丰富的功能。
- **🖥️ 艺术字命令**: 内置趣味 `/diao` 命令，显示酷炫的 oIo 艺术字。
## 📥 安装与依赖

1.  **下载插件**:
    *   前往 [**发布页面**](https://github.com/Giant-Diao-Team/DiaoCore/releases) (待创建) 下载最新的 `DiaoCore-x.x.x.jar` 文件。

2.  **安装核心插件**:
    *   将下载的 `DiaoCore-x.x.x.jar` 文件放入您服务器的 `plugins` 文件夹。

3.  **安装前置依赖**:
    *   **[推荐]** 本插件依赖 **`CloudPick`** 插件进行客户端通信。虽然 `DiaoCore` 在没有 `CloudPick` 的情况下也能启动，但涉及客户端通信的功能将无法使用`那这插件就基本没用了`。请确保您的 `plugins` 文件夹中已经安装了 `CloudPick-Bukkit-x.x.x.jar`。

4.  **启动服务器**:
    *   启动您的 Spigot/Paper 1.20.1+ 服务器。

## 📜 命令与权限

| 命令 | 描述 | 权限 |
| :--- | :--- | :--- |
| `/diao` | 显示大貂核心插件的 oIo 艺术字。 | 无需权限 |

## 🤝 UI界面通信 (`CloudPick` API)

**大貂核心 (DiaoCore)** 有很多功能通过 `CloudPick`  API和UI界面通信。

### **发送到客户端的标识符及用法**

| 标识符 | 描述 | 发送条件 | 内容 (`Object...`) | 示例 |
| :--- | :--- | :--- | :--- |
| `diaocore_kill` | 玩家击杀生物事件。 | 当玩家击杀任何生物时。 | `被击杀实体名称` (String), `击杀玩家名称` (String) | `data`: `["僵尸", "PlayerA"]` |

## ❓ 常见问题 (FAQ)

-   **Q: 插件加载时提示未找到 `CloudPick` 怎么办?**
    -   **A:** 请确保您已经将 `CloudPick-Bukkit` 的 jar 文件正确放入了服务器的 `plugins` 文件夹，并且其版本与您的服务端兼容。`DiaoCore` 在没有 `CloudPick` 的情况下也能运行，但涉及客户端通信的功能将无法工作。

-   **Q: `DiaoCore` 除了提供 API 外，还有其他什么功能吗？**
    -   **A:** 除了作为其他插件的 API 基础外，目前 `DiaoCore` 还提供了一个趣味的 `/diao` 命令。未来可能会根据需求添加更多基础的、通用的实用工具方法。

## 📝 参与贡献

欢迎任何形式的贡献！如果您发现了 Bug 或有任何好的建议，请随时提交 [**Issue**](https://github.com/Giant-Diao-Team/DiaoCore/issues) (待创建)。
---

**大貂核心 (DiaoCore)** - 为你的服务器提供坚实的核心基础！

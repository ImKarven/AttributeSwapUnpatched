# Attribute Swap Unpatched
As you may know, in version 26.1.2 pre-release 2, Mojang "patched" **attribute swapping**. It is a technique commonly used in the PvP community to gain advantage by quickly switching items in their hotbar to apply attributes of an item to another.

[Download the mod from modrinth](https://modrinth.com/mod/attribute-swap-unpatched)

## Why
This bug was discovered a few years ago and it changed modern PvP a lot. The removal of this bug from Mojang got many backlashes from the community. Thus, I created this mod to revert patches Mojang made to this bug and let players continue using attribute swap.

## How
Mojang patched this by switching your hotbar slot 1 tick later after a hotbar keybind is pressed on the client-side, the server-side has no changes in its logic, meaning:
- A vanilla server still accepts attribute swaps if the client does so.
- Attribute swapping is less consistent, but not entirely removed and it created some "side effects", such as not being able to switch slot and use item/place block at the same tick.

Certain servers may block attribute swap on their side (For example, a Paper server disables attribute swapping by default).
However, for this mod, both the server and client must have it if they want to use attribute swapping.

## Usage
- Installing this mod on the client lets you and other players that have this mod installed (if opened to LAN) perform attribute swaps in your worlds, but not in vanilla servers.
- Installing this mod on the server lets players on the server that have this mod installed to perform attribute swaps.

## Revert
In version 26.2 pre-release 3, Mojang reverted the fix made to attribute swapping. Now the client-side hotbar logic behaves similarly to older versions before the fix. This mod still reverts the fix for 26.2 pre-release 2, and possibly continues reverting the bug fix if Mojang decides to patch it again in future releases.

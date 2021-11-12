UBOOT_KCONFIG_SUPPORT = "1"
inherit resin-u-boot

FILESEXTRAPATHS_append := ":${THISDIR}/files"

SRC_URI_append = " \
    file://0001-Integrate-with-Balena-u-boot-environment.patch \
    file://0002-fat-Fix-sporadic-file-write-failure-when-saving-boot.patch \
    file://0001-Revert-cmd-nvedit-add-0x-prefix-for-hex-value.patch \
"

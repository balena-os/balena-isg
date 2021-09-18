UBOOT_KCONFIG_SUPPORT = "1"
inherit resin-u-boot

FILESEXTRAPATHS_append := ":${THISDIR}/files"


SRC_URI += " \
    file://0001-Integrate-with-Balena-u-boot-environment.patch \
"
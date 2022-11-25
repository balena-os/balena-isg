inherit kernel-balena deploy


FILESEXTRAPATHS:prepend := "${THISDIR}/linux-rockchip:"

SRC_URI += " \ 
	file://0004-recktech-modify_ttyName.patch \
"

KERNEL_IMAGETYPES:remove = "${ROCKCHIP_KERNEL_IMAGES}"

python () {
    # revert variable set in rockchip BSP
    d.setVar('KERNEL_IMAGETYPE_FOR_MAKE', d.getVar('KERNEL_IMAGETYPES'));
}

LICENSE = "MIT"

SRC_URI += " \
    file://main.c \
    file://startup.s \
    file://qemu.ld \
    file://Makefile \
    file://LICENSE.txt \
    file://lm3s \
    file://CMSIS \
"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8f5b865d5179a4a0d9037aebbd00fc2e"

S="${WORKDIR}"

do_compile(){
  oe_runmake ${EXTRA_OEMAKE}
}

#inherit qemuboot



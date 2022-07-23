DESCRIPTION = "Simple Library on yocto"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8f5b865d5179a4a0d9037aebbd00fc2e"

PR = "r0"

SRC_URI += " \
    file://LICENSE.txt \
    file://main.c \
"

S = "${WORKDIR}"

#PACKAGES = "${PN} ${PN}-dev ${PN}-dbg ${PN}-staticdev"

#RDEPENDS_${PN}-staticdev = ""
#RDEPENDS_${PN}-dev = ""
#RDEPENDS_${PN}-dbg = ""

do_compile(){
${CC} -c main.c -o main.o
${AR} rcs libexamplelib.a main.o
}

do_install(){
install -d ${D}${libdir}
install -m 0644 libexamplelib.a ${D}${libdir}
}


deviceTypesCommon = require '@resin.io/device-types/common'
{ networkOptions, commonImg, instructions } = deviceTypesCommon

module.exports =
	version: 1
	slug: 'isg-503'
	aliases: [ 'ISG503' ]
	name: 'ISG 503'
	arch: 'aarch64'
	state: 'released'

	instructions: commonImg.instructions
	gettingStartedLink:
		windows: 'https://www.balena.io/docs/learn/getting-started/isg-503/nodejs/'
		osx: 'https://www.balena.io/docs/learn/getting-started/isg-503/nodejs/'
		linux: 'https://www.balena.io/docs/learn/getting-started/isg-503/nodejs/'
	supportsBlink: true

	options: [ networkOptions.group ]

	yocto:
		machine: 'isg-503'
		image: 'balena-image-flasher'
		fstype: 'img'
		version: 'yocto-dunfell'
		deployArtifact: 'balena-image-flasher-isg-503.img'
		compressed: true

	configuration:
		config:
			partition:
				primary: 1
			path: '/config.json'

	initialization: commonImg.initialization

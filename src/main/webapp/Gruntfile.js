module.exports = function(grunt) {

    grunt.initConfig({
        pkg : grunt.file.readJSON('package.json'),
        copy: {
            main: {
                files: [
                    { expand: true, flatten: true,
                        src: ['node_modules/angular/angular.min.js'],
                        dest: 'generated/js/' },
                    { expand: true, flatten: true,
                        src: ['node_modules/angular-aria/angular-aria.min.js'],
                        dest: 'generated/js/' },
                    { expand: true, flatten: true,
                        src: ['node_modules/angular-ui-router/release/angular-ui-router.min.js'],
                        dest: 'generated/js/' },
                    { expand: true, flatten: true,
                        src: ['node_modules/mobile-angular-ui/dist/css/mobile-angular-ui-*'],
                        dest: 'generated/css/' },
                    { expand: true, flatten: true,
                        src: ['node_modules/mobile-angular-ui/dist/fonts/*'],
                        dest: 'generated/fonts/' },
                    { expand: true, flatten: true,
                        src: ['node_modules/mobile-angular-ui/dist/js/mobile-angular-ui.*.min.js'],
                        dest: 'generated/js/' },
                    { expand: true, flatten: true,
                        src: ['node_modules/bootstrap/dist/css/*.min.css'],
                        dest: 'generated/css/' },
                    { expand: true, flatten: true,
                        src: ['node_modules/bootstrap/dist/fonts/*'],
                        dest: 'generated/fonts/' }
                ]
            }
        },
        jshint: {
            files: ['Gruntfile.js', 'src/**/*.js']
        },
        watch: {
            files: ['**/*.js', '**/*.less'],
            tasks: ['jshint', 'uglify', 'less', 'copy']
        },
        uglify: {
            main: {
                files: {
                    'generated/js/IntegrationApp.min.js': ['src/**/*.js']
                }
            }
        },
        less: {
            main: {
                files: {
                    'generated/css/IntegrationApp.min.css': 'src/**/*.less'
                }
            }
        },
        connect: {
            server: {
                options: {
                    port: 9090,
                    base: '../webapp'
                }
            }
        }
    });
    
    grunt.loadNpmTasks('grunt-contrib-connect');
    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-watch');
    
    grunt.registerTask('default', ['jshint', 'uglify', 'less', 'copy']);
};
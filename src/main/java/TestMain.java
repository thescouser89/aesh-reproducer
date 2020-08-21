import org.aesh.command.AeshCommandRuntimeBuilder;
import org.aesh.command.Command;
import org.aesh.command.CommandDefinition;
import org.aesh.command.CommandException;
import org.aesh.command.CommandResult;
import org.aesh.command.CommandRuntime;
import org.aesh.command.impl.registry.AeshCommandRegistryBuilder;
import org.aesh.command.invocation.CommandInvocation;
import org.aesh.command.option.Argument;
import org.aesh.command.option.Option;
import org.aesh.command.registry.CommandRegistry;

@CommandDefinition(name = "test", description = "test")
public class TestMain implements Command {
    @Argument(required = true, description = "test required argument") private String text;

    @Option(shortName = 'v', overrideRequired = true, hasValue = false, description = "Verbose output")
    private boolean verbose = false;

    public CommandResult execute(CommandInvocation commandInvocation) throws CommandException, InterruptedException {
        System.out.println("Text: " + text);
        System.out.println("verbose: " + verbose);
        return null;
    }

    public static void main(String[] args) throws Exception {

        CommandRegistry registry = AeshCommandRegistryBuilder.builder().command(TestMain.class).create();
        CommandRuntime runtime = AeshCommandRuntimeBuilder.builder().commandRegistry(registry).build();
        runtime.executeCommand("test --verbose");
        System.out.println("Test considered successful only if error is thrown saying argument is required");
    }
}
